// ***********************************************
// This example commands.js shows you how to
// create various custom commands and overwrite
// existing commands.
//
// For more comprehensive examples of custom
// commands please read more here:
// https://on.cypress.io/custom-commands
// ***********************************************

// Custom command for API testing
Cypress.Commands.add('apiRequest', (method, url, body = null, failOnStatusCode = true) => {
  return cy.request({
    method: method,
    url: url,
    body: body,
    failOnStatusCode: failOnStatusCode,
  });
});
