import { Client, logger } from "camunda-external-task-client-js";
import { Variables } from "camunda-external-task-client-js";
import nodemailer from 'nodemailer';

// configuration for the Client:
//  - 'baseUrl': url to the Process Engine
//  - 'logger': utility to automatically log important events
const config = { baseUrl: "http://localhost:8080/engine-rest", use: logger };

// create a Client instance with custom configuration
const client = new Client(config);

async function sendEmail(reciever, subject, text) {
    const acc = await nodemailer.createTestAccount();
    try {
      const transporter = nodemailer.createTransport({
        host: "smtp.ethereal.email",
        port: 587,
        secure: false,
        auth: {
          user: acc.user,
          pass: acc.pass
        }
      });
  
      const mailOptions = {
        from: acc.user,
        to: reciever,
        subject: subject,
        text: text
      };
  
      const info = await transporter.sendMail(mailOptions);
      console.log('Email sent:', info.messageId);
    } catch (error) {
      console.error('Error occurred:', error);
    }
  }

client.subscribe("SendMail", async function({ task, taskService }) {
    const email = task.variables.get("Email");
    console.log("email: " + email)
    const subject = task.variables.get("Subject");
    console.log("subject: " + subject);
    const text = task.variables.get("Text");
    console.log("text: " + text)

    sendEmail(email, subject, text);
    
    await taskService.complete(task);
});