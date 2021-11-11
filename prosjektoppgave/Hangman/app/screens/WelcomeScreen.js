import React from "react";
import { ImageBackground, Text, StyleSheet } from "react-native";
import AppButton from "../components/AppButton";

import colors from "../config/colors";

function WelcomeScreen(props) {
  return (
    <ImageBackground
      style={styles.background}
      source={require("../assets/wsimg.jpg")}
      blurRadius={4}
    >
      <Text style={styles.information}>Information</Text>
      <AppButton style={styles.startButton} title="Start Game" />
    </ImageBackground>
  );
}

const styles = StyleSheet.create({
  background: {
    flex: 1,
    justifyContent: "flex-end",
    height: "100%",
    width: "100%",
    alignItems: "center",
  },
  information: {
    position: "absolute",
    top: 100,
    color: colors.white,
    fontSize: 17,
    fontWeight: "300",
  },
  startButton: {
    marginBottom: 50,
  },
});

export default WelcomeScreen;
