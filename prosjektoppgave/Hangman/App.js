import { StatusBar } from "expo-status-bar";
import React, { useState } from "react";
import {
  BackHandler,
  SafeAreaView,
  StyleSheet,
  Text,
  TextInput,
  View,
} from "react-native";
import WelcomeScreen from "./app/screens/WelcomeScreen";
import Hangman from "./app/screens/Hangman";

import { FontAwesome } from "@expo/vector-icons";
import AppButton from "./app/components/AppButton";
import AppTextInput from "./app/components/AppTextInput";

export default function App() {
  const [guess, setGuess] = useState("");

  return (
    // <View style={styles.container}>
    //   <FontAwesome name="info" size={60} color="dodgerblue" />
    //   <Hangman />
    //   <AppButton
    //     title="Click Me"
    //     onPress={() => console.log("button clicked from component")}
    //   />
    // </View>
    // <View style={styles.container}>
    //   <TextInput
    //     maxLength={1}
    //     onChangeText={(text) => setGuess(text)}
    //     placeholder="First Name"
    //     style={styles.textInput}
    //   />
    //   <Text>{guess}</Text>
    // </View>
    // <View style={styles.container}>
    //   <AppTextInput placeholder="username" icon="email" />
    // </View>
    <WelcomeScreen />
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "white",
    marginTop: 50,
    width: "100%",
    height: "100%",
  },
});
