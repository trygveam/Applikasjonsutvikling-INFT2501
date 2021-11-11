var words = ["Sugar", "Worm", "Soda", "Keyboard", "Car", "India"];

function randomWord() {
  return words[Math.floor(Math.random() * words.length)];
}

export { randomWord };
