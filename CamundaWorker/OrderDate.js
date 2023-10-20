//import { Client, logger } from "camunda-external-task-client-js";
import { Client, logger } from "camunda-external-task-client-js";
import { Variables } from "camunda-external-task-client-js";

// configuration for the Client:
//  - 'baseUrl': url to the Process Engine
//  - 'logger': utility to automatically log important events
const config = { baseUrl: "http://localhost:8080/engine-rest", use: logger };

// create a Client instance with custom configuration
const client = new Client(config);

// susbscribe to the topic: 'creditScoreChecker'
client.subscribe("OrderDate", async function({ task, taskService }) {
    const orderID = task.variables.get("OrderID");
    console.log("orderID: " + typeof(orderID));
    console.log("orderID: " + orderID);
    var orderDate = 0;

    console.log("is it true? " + orderID == 0);
    if (orderID == 0){
        console.log("orderDate: " + orderDate);
        orderDate = 0;
    } else{
        console.log("hello from else");
        orderDate = Math.floor(Math.random()*150);
    }

    const processVar = new Variables();
    processVar.set("orderDate", orderDate);
    console.log(orderDate);
    await taskService.complete(task, processVar);
});