create database J209_CarRentalSystem;
use J209_CarRentalSystem;


CREATE TABLE Vehicle (vehicleID INT PRIMARY KEY, make VARCHAR(255), model VARCHAR(255), year INT, dailyRate DECIMAL(8, 2), status VARCHAR(20) check (status IN ("available", "notavailable")), passengerCapacity INT, engineCapacity int);
CREATE TABLE Customer (customerID INT  auto_increment primary KEY, firstName VARCHAR(255), lastName VARCHAR(255), email VARCHAR(255), phoneNumber varchar(10));
CREATE TABLE Lease (leaseID INT   primary KEY, vehicleID INT, customerID INT, startDate DATE, endDate DATE, type VARCHAR(20) CHECK (type IN ('DailyLease', 'MonthlyLease')), state varchar(20) check (state IN ("active", "expired")), FOREIGN KEY (vehicleID) REFERENCES Vehicle(vehicleID), FOREIGN KEY (customerID) REFERENCES Customer(customerID));
CREATE TABLE Payment (paymentID INT PRIMARY KEY, leaseID INT, paymentDate DATE, amount DECIMAL(10, 2), FOREIGN KEY (leaseID) REFERENCES Lease(leaseID));


select * from vehicle;
select * from customer;
select * from lease;
select* from payment;
