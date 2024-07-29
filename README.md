# Spring Boot Employability Assessment

This project is an ecommerce application for managing and redeeming discount coupons.

# Members
- Sebastian Moreno
- Julian Usuga
- Santiago Pelaez
- Daniel Parra

## Requirements
- Docker installed
- Java 17 installed

# DIAGRAMS

## Entities and Relationship
![Entities and Relationship](https://res.cloudinary.com/dycsevcp0/image/upload/v1722270711/riwi-performance-test/emxnobt9e7xj8lnhjug6.png)

## Architecture
![Architecture](https://res.cloudinary.com/dycsevcp0/image/upload/v1722270711/riwi-performance-test/xd5za26rdh7l4loresz0.png)

## Use Cases
![Use Cases](https://res.cloudinary.com/dycsevcp0/image/upload/v1722270711/riwi-performance-test/itdnimcut0vvaydjeuxf.png)


# Explain our solution
We separate the application in 3 main tables (User, Product, Voucher) and an intermediate one to manage the history of redeemed vouchers, we allow to create user, product and voucher, and the user has permissions to see the products and vouchers available and their voucher history, we validate that the vucher are available, that they have not expired and have not been redeemed, we use specialized queries.


## Instructions to Start the Application

### Step 1: Clone the Repository

First, clone the repository from GitHub:

```bash
git clone https://github.com/SMoreno73/riwi-performance-test.git
```

Then, navigate to the project directory:

```bash
cd riwi-performance-test
```

### Step 2: Start the Services with Docker Compose

To start the necessary services using Docker Compose, run the following command:

```bash
docker-compose up
```

This will bring up all the services defined in the `docker-compose.yml` file.

### Step 3: Set Up the Development Environment

Open your favorite code editor and make sure you have Java 17 installed.

To verify that Java 17 is installed correctly, run the following command:

```bash
java -version
```

It should display something similar to:

```plaintext
java version "17.0.x"
Java(TM) SE Runtime Environment (build 17.0.x+xx)
Java HotSpot(TM) 64-Bit Server VM (build 17.0.x+xx, mixed mode, sharing)
```

### Step 4: Run the Application

Once you have verified that you have Java 17 installed and the Docker services are running, you can start the application from your code editor.

1. Open the project in your preferred editor (Eclipse, IntelliJ IDEA, VSCode, etc.).
2. Navigate to the main application file (usually `Application.java` or similar).
3. Run the application from your editor.

### Additional Notes

- Make sure the ports defined in `docker-compose.yml` are not being used by other services on your machine.
- If you need to make changes to the Docker configuration, you can edit the `docker-compose.yml` file as needed.

## Contact

If you have any questions or issues, please contact [SMoreno73](https://github.com/SMoreno73).
```

This `README.md` file provides clear and detailed instructions to clone the repository, start the services using Docker Compose, and run the application with Java 17.