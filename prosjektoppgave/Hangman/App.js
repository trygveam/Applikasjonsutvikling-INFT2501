import { StatusBar } from "expo-status-bar";
import React from "react";
import { BackHandler, StyleSheet, Text, View } from "react-native";
import WelcomeScreen from "./app/screens/WelcomeScreen";
import Hangman from "./app/screens/Hangman";

import { FontAwesome } from "@expo/vector-icons";
import AppButton from "./app/components/AppButton";

export default function App() {
  return (
    // <View style={styles.container}>
    //   <FontAwesome name="info" size={60} color="dodgerblue" />
    //   <Hangman />
    //   <AppButton
    //     title="Click Me"
    //     onPress={() => console.log("button clicked from component")}
    //   />
    // </View>
    <View style={styles.container}>
      <WelcomeScreen />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    alignItems: "center",
    justifyContent: "center",
  },
});
