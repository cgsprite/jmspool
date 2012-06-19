/**
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License. 
 *
 **/
package org.fusesource.jms.xapool;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Topic;
import javax.jms.TopicPublisher;

/**
 * A pooled {@link javax.jms.TopicPublisher}
 */
public class PooledTopicPublisher extends PooledProducer implements TopicPublisher {

    public PooledTopicPublisher(final TopicPublisher messageProducer,
                                final Destination destination) throws JMSException {
        super(messageProducer, destination);
    }

    public Topic getTopic() throws JMSException {
        return getTopicPublisher().getTopic();
    }

    public void publish(final Message message) throws JMSException {
        getTopicPublisher().publish(message);
    }

    public void publish(final Message message, final int i, final int i1, final long l)
            throws JMSException {
        getTopicPublisher().publish(message, i, i1, l);
    }

    public void publish(final Topic topic, final Message message) throws JMSException {
        getTopicPublisher().publish(topic, message);
    }

    public void publish(final Topic topic, final Message message, final int i, final int i1, final long l)
            throws JMSException {
        getTopicPublisher().publish(topic, message, i, i1, l);
    }

    protected TopicPublisher getTopicPublisher() {
        return (TopicPublisher) getMessageProducer();
    }
}