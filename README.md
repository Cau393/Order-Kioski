# Cafe Order Kiosk

This project is a simple **Graphical User Interface (GUI)** application for a digital order kiosk, built using Java Swing. It allows a user to browse menu items, manage a shopping cart, and view a calculated receipt including tax.

## Project Purpose and Logic Flow

The application provides a graphical interface for simulating a café kiosk ordering system. Users interact with the GUI to select items, adjust quantities, and finalize their order.

### Main Classes

* **`com.caue.kioski.app.Main`**: The main entry point for the application. It initializes the GUI by creating and displaying the **`MainFrame`** within the Swing event-dispatching thread.
* **`com.caue.kioski.ui.MainFrame`**: The main window of the application. It constructs the various panels for item browsing, cart display (using a `JTable`), quantity input, and displays the running subtotal, tax, and total labels.
* **Models (`MenuItem`, `Cart`, `CartItem`)**: These are the core data structures.
    * `MenuItem`: Represents a product in the catalog with a name, price, and category.
    * `Cart`: Holds a collection of `CartItem`s. It handles business logic like merging items (e.g., adding 2 coffees then 1 more coffee results in one line item of 3 coffees) and calculating the order subtotal.
* **Repositories (`InMemoryCatalogRepository`, `FileReceiptRepository`)**:
    * `InMemoryCatalogRepository`: Provides the list of available `MenuItem`s (Coffee, Tea, Croissant, etc.). In this project, it's a hard-coded list.
    * `FileReceiptRepository`: Implements the logic to save a generated receipt to a timestamped text file.
* **Services (`ReceiptService`, `FlatRateTaxCalculator`)**:
    * `FlatRateTaxCalculator`: An implementation of the `TaxCalculator` interface that applies a simple flat-rate tax to a `BigDecimal` amount (typically 6%).
    * `ReceiptService`: Responsible for taking a `Cart`, applying tax calculations, and formatting the complete order into a list of strings (the receipt content).

### Logic Flow

1.  The application starts in `com.caue.kioski.app.Main`, which initializes the Swing GUI by making the `MainFrame` visible.
2.  The GUI components, including the menu list and cart table, are rendered.
3.  User interactions (e.g., clicking **"Add to Cart"** or **"Checkout..."**) trigger methods in the underlying business logic (like `Cart.add` or `ReceiptService.render`) to update the cart data and recalculate totals.

***

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

Once the project is built, you can run the GUI application using the `java` command, pointing to the new main class:

```sh
java -cp target/Order_Kiosk-1.0-SNAPSHOT.jar com.caue.kioski.app.Main
```

### How to run tests:
```
mvn test
```
