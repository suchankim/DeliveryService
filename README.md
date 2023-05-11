# 

## 1.EventStorming Model : Design Level
![image](https://github.com/suchankim/DeliveryService/assets/26198168/1ade2296-8f60-473b-a136-c1cf907ccfb0)

## 2.Saga (Pub / Sub)
### 1) Order.java
![image](https://github.com/suchankim/DeliveryService/assets/26198168/59820a9c-fd2f-4bc9-9190-43ed86f0f9ac)

### 2) Cooking.java
![image](https://github.com/suchankim/DeliveryService/assets/26198168/fbaf74c5-663a-45b8-ba71-1cf728edac84)

### 3) Delivery.java
![image](https://github.com/suchankim/DeliveryService/assets/26198168/b3ed5831-81b2-4ad3-bf73-6e90ed45fc04)

## 3.CQRS
![image](https://github.com/suchankim/DeliveryService/assets/26198168/a1243b1d-1c9e-4b73-b613-174841f87c1e)

## 4.Compensation / Correlation
### 1) 주문
![image](https://github.com/suchankim/DeliveryService/assets/26198168/5617cf43-ecef-4f20-a282-368a8d8e9da0)

### 2) 주문수용
![image](https://github.com/suchankim/DeliveryService/assets/26198168/ddbea29c-3cbf-4298-8d33-0f532fd73193)

### 3) 요리시작
![image](https://github.com/suchankim/DeliveryService/assets/26198168/74a4f8e4-f58b-4d00-9d6d-2a6d56e121fc)

### 4) 요리종료
![image](https://github.com/suchankim/DeliveryService/assets/26198168/c5d7e656-10ae-467a-8f81-8aa3e0bcf2ba)

### 5) KAFKA모니터링
![image](https://github.com/suchankim/DeliveryService/assets/26198168/764340ae-e85c-4f97-acc2-a0904665eb11)

```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd kafka
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- front
- store
- rider
- message
- dashboard


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- front
```
 http :8088/orders id="id" customerId="customerId" storeId="storeId" foodCode="foodCode" address="address" options="options" status="status" price="price" 
 http :8088/payments id="id" orderId="orderId" price="price" 
```
- store
```
 http :8088/cookings id="id" orderId="orderId" foodCode="foodCode" storeId="storeId" customerId="customerId" status="status" options="options" 
```
- rider
```
 http :8088/deliveries id="id" orderId="orderId" address="address" status="status" storeId="storeId" 
```
- message
```
```
- dashboard
```
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

