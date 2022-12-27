# SB_KafkaConsumer - CMD COMMANDS FOR KAFKA 

# TO START THE ZOOKEEPER
C:\Users\Dell\Downloads\kafka\bin\windows>zookeeper-server-start.bat ../../config/zookeeper.properties


# TO START THE KAFKA SERVER
C:\Users\Dell\Downloads\kafka\bin\windows>kafka-server-start.bat ../../config/server.properties


# TO CREATE A NEW TOPIC IN THE KAFKA SERVER
C:\Users\Dell\Downloads\kafka\bin\windows> kafka-topics.bat --create --topic <TOPICNAME> --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1


# TO CHECK THE MESSAGES ON ANY TOPIC 
C:\Users\Dell\Downloads\kafka\bin\windows>kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic <TOPICNAME>
