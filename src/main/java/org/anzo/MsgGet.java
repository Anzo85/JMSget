package org.anzo;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MsgGet {

    public static void main(String[] args) throws Exception {

        Connection connection = new ActiveMQConnectionFactory("tcp://localhost:61616").createConnection();

        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("Test");
        MessageConsumer recever = session.createConsumer(queue);
        TextMessage msg = (TextMessage) recever.receive();
        System.out.println(msg.getText());
        connection.close();

    }
}
