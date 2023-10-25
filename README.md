# SPblocks
The Cipher Transformation Project is a Java application that demonstrates the use of S-Box and P-Box transformations. It takes an 8-bit hexadecimal number as input, applies these transformations, and displays the results.

## How to Use

1. Clone the repository to your local machine
2. Navigate to the project directory
3. Compile the Java code: `javac Main.java`
4. Run the application:`java Main`
5. Follow the on-screen instructions to input an 8-bit hexadecimal number. The program will then perform the following transformations and display the results:

   - S-Box Transformation
   - P-Box Transformation
   - Reverse P-Box Transformation
   - Reverse S-Box Transformation

## Project Structure

- `Main.java`: The main application that takes user input and calls methods from the `Cipher` class.
- `Cipher.java`: The `Cipher` class contains methods for S-Box and P-Box transformations.
- `CipherTest.java`: Some preseted tests to check that application is working with some data
## Input Validation

The application includes input validation to ensure that the input is an 8-bit value (between 0 and 255).
