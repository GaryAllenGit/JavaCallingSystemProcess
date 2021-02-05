"Java Calling a System Process" demo.

Dr Gary Allen, The University of Huddersfield

A simple demo to show haw a Java program can call a system process.

In this case the Java program runs the unix/linux 'ls' command with the '-l' flag. It gets the output from the system process and prints it to standard-out.

NOTE the need to set the directory that is to be listed by editing this line:

	processBuilder.directory(new java.io.File("/home/gary"));

If it is not set to a valid directory name then it will crash.


