import React, { Component, useState } from "react";
import {
  BackHandler,
  StyleSheet,
  Text,
  Image,
  View,
  Button,
  TextInput,
} from "react-native";
import { randomWord } from "../components/Words";

const images = [
  require("../assets/hangman_states/state0.png"),
  require("../assets/hangman_states/state1.png"),
  require("../assets/hangman_states/state2.png"),
  require("../assets/hangman_states/state3.png"),
  require("../assets/hangman_states/state4.png"),
  require("../assets/hangman_states/state5.png"),
  require("../assets/hangman_states/state6.png"),
  require("../assets/hangman_states/state7.png"),
];

class Hangman extends Component {
  static defaultProps = {
    allowedWrong: 0,
  };

  constructor(props) {
    super(props);
    this.state = {
      answer: randomWord(),
      guessed: new Set([]),
      wrongGuesses: 0,
    };
  }

  render() {
    return (
      <View style={styles.container}>
        <Text>{this.state.answer}</Text>
        <Text>
          Wrong guesses: {this.state.wrongGuesses} of {this.props.allowedWrong}
        </Text>
        <Image source={images[this.state.wrongGuesses]}></Image>
        <TextInput
          placeholder="Single Letter"
          style={styles.textInput}
        ></TextInput>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    alignItems: "center",
    justifyContent: "center",
  },
  textInput: {
    borderColor: "green",
    borderWidth: 1,
  },
});

export default Hangman;
