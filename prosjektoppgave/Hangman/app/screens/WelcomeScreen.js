import React from "react";
import { ImageBackground, StyleSheet } from "react-native";
import AppButton from "../components/AppButton";

import style from "../config/styles";
import colors from "../config/colors";
import AppText from "../components/AppText";

function WelcomeScreen(props) {
  return (
    <ImageBackground
      style={styles.background}
      source={require("../assets/wsimg.jpg")}
      blurRadius={4}
    >
      <AppText style={styles.header}>Welcome</AppText>
      <AppText style={styles.information}>
        This is a long text explaining the rules and shit aboyt this game, This
        is a long text explaining the rules and shit aboyt this game , This is a
        long text explaining the rules and shit aboyt this game, This is a long
        text explaining the rules and shit aboyt this game , This is a long text
        explaining the rules and shit aboyt this game, This is a long text
        explaining the rules and shit aboyt this game
      </AppText>
      <AppButton style={styles.startButton} title="Start Game" />
    </ImageBackground>
  );
}

const styles = StyleSheet.create({
  background: {
    flex: 1,
    justifyContent: "center",
    height: "100%",
    width: "100%",
    alignItems: "center",
  },
  header: {
    position: "absolute",
    top: 100,
    color: colors.white,
  },
  information: {
    color: colors.white,
  },
  startButton: {
    position: "absolute",
    bottom: 30,
  },
});

export default WelcomeScreen;
