# Order Kiosk CLI

This project is a simple command-line interface (CLI) application for a digital order kiosk. It allows a user to manage a shopping cart, view menu items, and generate a final receipt with tax calculations.

## Project Purpose and Logic Flow

The application provides a text-based interface for simulating a kiosk ordering system. A user can interact with the program through a set of simple commands to build an order and see the final cost.

### Main Classes

* **`com.caue.kioski.cli.Main`**: The main entry point for the application. It initializes all necessary services and repositories and contains the primary input loop for processing user commands.
* **Models (`MenuItem`, `Cart`, `CartItem`)**: These are the core data structures.
    * `MenuItem`: Represents a product in the catalog with a name, price, and category.
    * `Cart`: Holds a collection of `CartItem`s. It handles business logic like merging items (e.g., adding 2 coffees then 1 more coffee results in one line item of 3 coffees) and calculating the order subtotal.
* **Repositories (`InMemoryCatalogRepository`, `FileReceiptRepository`)**:
    * `InMemoryCatalogRepository`: Provides the list of available `MenuItem`s. In this project, it's a hard-coded list.
    * `FileReceiptRepository`: Implements the logic to save a generated receipt to a timestamped text file.
* **Services (`ReceiptService`, `FlatRateTaxCalculator`)**:
    * `FlatRateTaxCalculator`: An implementation of the `TaxCalculator` interface that applies a simple flat-rate tax to a `BigDecimal` amount.
    * `ReceiptService`: Responsible for taking a `Cart`, applying tax calculations, and formatting the complete order (items, subtotal, tax, and total) into a list of strings ready for printing.

### Logic Flow

1.  The `Main` class starts and initializes the `InMemoryCatalogRepository`, `Cart`, and `ReceiptService`. The `ReceiptService` is configured with a `FlatRateTaxCalculator` set to 6%.
2.  The application enters a command loop, printing a `> ` prompt and waiting for user input.
3.  User input is parsed into commands. The available commands are:
    * `menu`: Lists all items from the `InMemoryCatalogRepository` with their prices.
    * `add <Name> <Qty>`: Adds a specified quantity of an item to the cart. For example: `add Coffee 2`.
    * `remove <Name>`: Removes an item line from the cart.
    * `show`: Displays the current items in the cart, their quantities, and line totals.
    * `receipt`: Generates and prints a full receipt, including all items, the subtotal, the calculated tax, and the grand total.
    * `help`: Prints the list of available commands.
    * `quit`: Exits the application.

---

## How to Build and Run

This is a standard Maven project. It is configured to use Java 21.

### Prerequisites

* Java JDK 21 or newer
* Apache Maven

### Building the Project

1.  Open a terminal in the project's root directory (where `pom.xml` is located).
2.  Run the Maven `package` command:

    ```sh
    mvn package
    ```

3.  This will compile the code, run tests, and create a JAR file in the `target/` directory, typically named `Order_Kiosk-1.0-SNAPSHOT.jar`.

### Running the Program

Once the project is built, you can run the CLI application using the `java` command.

```sh
java -cp target/Order_Kiosk-1.0-SNAPSHOT.jar com.caue.kioski.cli.Main
```

### How to run tests:
```
mvn test
```

