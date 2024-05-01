# Gilded Rose Refactoring Kata
 
Copied over from: https://github.com/emilybache/GildedRose-Refactoring-Kata

It is my attempt at the exercise in Java, thus it's slimmed down version of the original repository.

The idea of the exercise is to do some deliberate practice, and improve skills at designing test cases and refactoring. The idea is not to re-write the code from scratch, but rather to practice taking small steps, running the tests often, and incrementally improving the design.

Use Java Version 11.

Run ```sh start_texttest.sh```


## My notes

Some things observed whilst doing it:

▷ Write tests - you can confidently change anything if the tests are solid. It was the cornerstone of effectively refactoring a convoluted codebase and retaining 'always working' code.

▷ Pick a focus area - select a small portion to improve (e.g. one 'else' block) - write tests for and refactor just that bit. And then repeat.

▷ Mutation test - verify newly created tests do the job by changing the code you're testing; for example, move/remove code, or change a constant value.

▷ Work incrementally - a series of small, simple refactorings are easier and safer. New ideas emerge from small refactorings. And you can stop-start; real life rarely gives you the time you want to refactor!

▷ Avoid over-engineering - in this case, having separate polymorphic Item classes for simple logic seemed unnecessary. However, the code leaves things open to doing so when appropriate. 