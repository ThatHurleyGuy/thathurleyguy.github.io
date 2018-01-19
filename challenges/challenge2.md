Mr Hurley has heard that his previous message encoding was broken. This time he's got some help from a fellow spy. Your job is to find the secret passcode.

# Part 1

You've discovered 2 images that Mr Hurley sent to North Korean intelligence this time. They both look like gibberish, but you've got a feeling they're related.

![Scrambled message 1](scrambled2.png "Scrambled message 1")

![Scrambled message 2](scrambled1.png "Scrambled message 2")

This reminds you of a technique used for backing up data. A simple way to backup data is to just make a copy of it. So if you have 1GB of important data that needs to be backed up, you need a total of 2GB to store the original and the copy. However, you can do a little better by using the bitwise XOR operator.

| a | b | a XOR b |
| - | - | :-----: |
| 0 | 0 |    0    |
| 0 | 1 |    1    |
| 1 | 0 |    1    |
| 1 | 1 |    0    |

This operator can be used to make backups smaller. For example, let's look at backing up 2 single bits. The naive method mentioned above would require 4 bits (1 bit for the original `a`, 1 bit for the original `b`, 1 bit for the copy of `a`, and 1 bit for the copy of `b`). But using XOR, we can safely store the data using just 3 bits (1 bit for the original `a`, 1 bit for the original of `b`, and 1 bit for `a XOR b`). Now in the event that we lose the original copy of `a`, we can look at the original copy of `b` and the backup data of `a XOR b` to compute the original value of a using the table above (Or using the `^` operator in java). Can you use the XOR operator in java on the pixels of the 2 scrambled images to compute the original image Mr Hurley tried to send?

# Part 2



-- You've recently heard rumors that Mr Hurley is an undercover spy from North Korea. Last week you intercepted a message he sent back North Korean intelligence. The message appears to be hidden inside a scrambled image. Time to break out your programming skills and see what he's up to! Here's the image you intercepted:
--
-- ![Scrambled message](odds_and_evens.png "Scrambled message")
--
-- The image appears to just be random noise, but you're confident there's a hidden message in it. Your goal is to write a program that will look at each invididual pixel of the original image, and use the values to generate a new image.
--
-- Here is an example project that you can import into intellij or eclipse that will have some code to help you get started.
--
-- [Example Project](SecretChallenge1.zip)
--
-- To import the project into BlueJ click Project -> Open ZIP/JAR and select the zip file you downloaded. It should open the project, the Main.java file is the only file you need to check.
--
-- To import the project into eclipse File -> Open projects from file system. Click "Archive" to the right of the "Import source" field and select the archive file you downloaded.
--
-- Hint: Look at the filename of the scrambled image. Also, your output image should be a single color background with text written in the center.
