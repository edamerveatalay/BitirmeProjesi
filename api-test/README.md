# Pet Store API Testing Project

This project contains automated API tests for the [Pet Store Swagger API](https://petstore.swagger.io/). The tests cover all the main HTTP methods (GET, POST, PUT, DELETE) for the pet, store, and user endpoints.

## Table of Contents
- [Project Structure](#project-structure)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Running Tests](#running-tests)
- [Test Reports](#test-reports)
- [Postman Collection](#postman-collection)

## Project Structure

```
api-test/
├── cypress/
│   ├── e2e/
│   │   └── petstore/
│   │       ├── pet.api.spec.js     # Tests for pet endpoints
│   │       ├── store.api.spec.js   # Tests for store endpoints
│   │       └── user.api.spec.js    # Tests for user endpoints
│   ├── fixtures/                   # Test data (not used in this project)
│   └── support/
│       ├── commands.js             # Custom Cypress commands
│       └── e2e.js                  # Support file with global configurations
├── cypress.config.js               # Cypress configuration
├── package.json                    # Project dependencies and scripts
├── postman_collection.json         # Postman collection for manual testing
└── README.md                      # Project documentation
```

## Technologies Used

- [Node.js](https://nodejs.org/) - JavaScript runtime
- [Cypress](https://www.cypress.io/) - End-to-end testing framework
- [Mochawesome](https://github.com/adamgruber/mochawesome) - Test reporter for generating HTML reports

## Installation

1. Clone the repository:
```bash
git clone <repository-url>
cd api-test
```

2. Install dependencies:
```bash
npm install
```

## Running Tests

The project provides several npm scripts to run tests:

- Run all tests:
```bash
npm test
```

- Run tests with Cypress UI:
```bash
npm run test:open
```

- Run specific test suites:
```bash
# Run only pet API tests
npm run test:pet

# Run only store API tests
npm run test:store

# Run only user API tests
npm run test:user

# Run all tests sequentially
npm run test:all
```

## Test Reports

After running tests with `npm test` or any of the test commands, detailed HTML reports will be generated in the `cypress/reports` directory. These reports include:

- Test results with pass/fail status
- Duration of each test
- Error messages and stack traces for failed tests
- Charts and statistics

To view the reports, open the HTML files in your browser from the `cypress/reports` directory.

## Postman Collection

The project includes a Postman collection (`postman_collection.json`) that can be imported into Postman for manual API testing. The collection contains all the endpoints covered in the automated tests.

### How to use the Postman collection:

1. Open Postman
2. Click "Import" and select the `postman_collection.json` file
3. The collection will be imported with all the requests organized by endpoint type (pet, store, user)
4. Create a Postman environment if needed to set variables like `petId`, `orderId`, and `username`
