// Import necessary modules or classes
import BaseClass from "../util/baseClass";
import DataStore from "../util/DataStore";
import ExampleClient from "../api/exampleClient";

// Define the ChexPage class, extending the BaseClass
class ChexPage extends BaseClass {

    constructor() {
        super();
        // Bind class methods to the instance
        this.bindClassMethods(['onGet', 'onCreate', 'renderExample'], this);
        // Initialize the data store
        this.dataStore = new DataStore();
    }

    /**
     * Once the page has loaded, set up the event handlers and fetch the Chex Mix list.
     */
    async mount() {
        // Add event listeners for form submissions
        document.getElementById('add-chex-mix-form').addEventListener('submit', this.onAddChexMix);
        document.getElementById('remove-chex-mix-form').addEventListener('submit', this.onRemoveChexMix);
        // Create an instance of the ExampleClient for API requests
        this.client = new ExampleClient();

        // Add a change listener to update the UI when Chex Mix data changes
        this.dataStore.addChangeListener(this.renderChexMix)
    }

    // Render Methods --------------------------------------------------------------------------------------------------

    async renderChexMix() {
        // Get the result area element
        let resultArea = document.getElementById("chex-mix-info");

        // Get the Chex Mix data from the data store
        const chexMixList = this.dataStore.get("chexMixList");

        if (chexMixList) {
            // Display Chex Mix information in the result area
            resultArea.innerHTML = `
                <h2>Chex Mix Inventory</h2>
                <ul>
                    ${chexMixList.map(chexMix => `<li>${chexMix.type} - ${chexMix.quantity} bags</li>`).join('')}
                </ul>
            `;
        } else {
            // Display a message if there's no Chex Mix data
            resultArea.innerHTML = "No Chex Mix data available.";
        }
    }

    // Event Handlers --------------------------------------------------------------------------------------------------

    async onAddChexMix(event) {
        // Prevent the page from refreshing on form submit
        event.preventDefault();

        // Get values from the form fields
        let type = document.getElementById("type-field").value;
        let quantity = document.getElementById("quantity-field").value;

        // Set the Chex Mix data to null before making the API request
        this.dataStore.set("chexMixList", null);

        // Make the API request to add Chex Mix
        let result = await this.client.addChexMix(type, quantity, this.errorHandler);

        // Set the updated Chex Mix data to the data store
        this.dataStore.set("chexMixList", result);

        if (result) {
            this.showMessage(`Added ${quantity} bags of ${type} to Chex Mix inventory!`);
        } else {
            this.errorHandler("Error adding Chex Mix! Try again...");
        }
    }

    async onRemoveChexMix(event) {
        // Prevent the page from refreshing on form submit
        event.preventDefault();

        // Get values from the form fields
        let type = document.getElementById("remove-type-field").value;
        let quantity = document.getElementById("remove-quantity-field").value;

        // Set the Chex Mix data to null before making the API request
        this.dataStore.set("chexMixList", null);

        // Make the API request to remove Chex Mix
        let result = await this.client.removeChexMix(type, quantity, this.errorHandler);

        // Set the updated Chex Mix data to the data store
        this.dataStore.set("chexMixList", result);

        if (result) {
            this.showMessage(`Removed ${quantity} bags of ${type} from Chex Mix inventory!`);
        } else {
            this.errorHandler("Error removing Chex Mix! Try again...");
        }
    }
}

/**
 * Main method to run when the page contents have loaded.
 */
const main = async () => {
    const chexPage = new ChexPage();
    chexPage.mount();
};

// Add an event listener to run the main method when the DOM is loaded
window.addEventListener('DOMContentLoaded', main);