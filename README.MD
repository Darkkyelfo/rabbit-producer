docker command
docker run --rm -d -p 15672:15672 -p 5672:5672 -e RABBITMQ_DEFAULT_USER=user_rabbit -e RABBITMQ_DEFAULT_PASS=rabbit rabbitmq:3-management