package und.demo.jms.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Configurable
public class JMSConnectionConfig {
    @Bean
    public Context getContext() throws NamingException {
        Context context = new InitialContext();
        return context;
    }
    @Bean
    public QueueConnectionFactory getQueueConnectionFactory(Context context) throws Exception {

        QueueConnectionFactory queueConnectionFactory= (QueueConnectionFactory) context.lookup("QueueConnectionFactory");
        return queueConnectionFactory;
    }
    @Bean
    public TopicConnectionFactory getTopicConnectionFactory(Context context) throws Exception {
        TopicConnectionFactory topicConnectionFactory= (TopicConnectionFactory) context.lookup("TopicConnectionFactory");
        return topicConnectionFactory;
    }
    @Bean
    public QueueConnection getQueueConnection(QueueConnectionFactory connectionFactory) throws JMSException {
        return connectionFactory.createQueueConnection();
    }
    @Bean
    public TopicConnection getTopicConnection(TopicConnectionFactory connectionFactory) throws JMSException {
        return connectionFactory.createTopicConnection();
    }
    @Bean
    public Queue getQueue(Context context) throws Exception {
        Queue queue= (Queue) context.lookup("MyQueue");
        return queue;
    }
    @Bean
    public Topic getTopic(Context context) throws Exception {
        Topic topic= (Topic) context.lookup("MyTopic");
        return topic;
    }
}
