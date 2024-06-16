# ATM Management System

## Overview

The ATM Management System is a Spring Boot application designed to manage user accounts and banking operations. It provides features for creating, updating, and deleting user accounts and banks, as well as handling various banking transactions such as fund transfers between accounts. The application includes specific logic for handling inter-bank transfers with a deduction fee.

## Features

- **User Account Management**
  - Create, read, update, and delete user accounts.
  - Manage account balances and PINs.
- **Bank Management**
  - Create, read, update, and delete bank details.
- **Fund Transfers**
  - Transfer funds between accounts.
  - Apply a 10% deduction fee for inter-bank transfers.
- **Security**
  - JWT authentication for secure access.


## Technology Stack

- **Backend**: Spring Boot
- **Database**: MySQL (AWS RDS)
- **Security**: JWT, Spring Security


## Getting Started

### Prerequisites

- Java 11 or higher
- Maven
- MySQL


### Installation

1. **Clone the repository**
   ```sh
   git clone https://github.com/your-github/ATM-Management-System.git
   cd ATM-Management-System
