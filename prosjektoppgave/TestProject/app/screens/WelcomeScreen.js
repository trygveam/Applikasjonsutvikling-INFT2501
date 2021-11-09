import React from "react";
import { ImageBackground, Image, StyleSheet } from "react-native";

function WelcomeScreen(props) {
  console.log("halo");
  return (
    <ImageBackground
      style={styles.background}
      source={require("../assets/wsimg.jpg")}
    ></ImageBackground>
  );
}

const styles = StyleSheet.create({
  background: {
    flex: 1,
  },
});

export default WelcomeScreen;
