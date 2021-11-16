import React, { useState } from "react";
import { StyleSheet } from "react-native";
import AppText from "../components/AppText";
import styles from "../config/styles";
import Screen from "../components/Screen";

function GameScreen(props) {
  const [guess, setGuess] = useState("");

  return (
    <Screen style={styles.container}>
      <AppText>Game Screen</AppText>
    </Screen>
  );
}
const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "dodgerblue",
  },
});
export default GameScreen;
