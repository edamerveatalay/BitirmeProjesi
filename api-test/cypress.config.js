const { defineConfig } = require('cypress');

module.exports = defineConfig({
  e2e: {
    setupNodeEvents(on, config) {
      require('cypress-mochawesome-reporter/plugin')(on);
    },
    specPattern: 'cypress/e2e/**/*.spec.js',  // Updated to match our .spec.js files
    reporter: 'cypress-mochawesome-reporter',
    reporterOptions: {
      charts: true,
      reportPageTitle: 'Pet Store API Test Report',
      embeddedScreenshots: true,
      inlineAssets: true,
    },
    video: false,
    screenshotOnRunFailure: true,
    baseUrl: 'https://petstore.swagger.io/v2',
    retries: {
      // Configure retry attempts for tests
      runMode: 2,      // Retry failed tests twice in normal runs
      openMode: 1      // Retry failed tests once in open mode
    },
    defaultCommandTimeout: 10000,  // Increase default command timeout
    requestTimeout: 15000,         // Increase API request timeout
  },
});
