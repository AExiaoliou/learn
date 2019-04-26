/*
* System.out is using BufferedWriter to manage output, which could not manage separator
*/
PrintWriter out = new PrintWriter(System.out, true);
/*
* If you ignore the second argment 'autoFlush', it will default with false
* And then, because System.out is null, it will close somewhere
* So turn 'autoFlush' to true
* Now, every time you use 'println()' and 'printf()' will flush the output stream 
*/
