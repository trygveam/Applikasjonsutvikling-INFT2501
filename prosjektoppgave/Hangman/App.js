import React, { useState } from "react";
import { Button, Text } from "react-native";
import { createStackNavigator } from "@react-navigation/stack";
import { NavigationContainer } from "@react-navigation/native";

const ws = ({ navigation }) => (
  <Screen>
    <Text>helo</Text>
    <Button title="clicke me" onPress={() => navigation.navigate("gs")} />
  </Screen>
);

const gs = () => <GameScreen />;

const Stack = createStackNavigator();
const StackNavigator = () => (
  <StackNavigator>
    <Stack.Screen name="WelcomeScreen" component={ws} />
    <Stack.Screen name="GameScreen" component={gs} />
  </StackNavigator>
);
export default function App() {
  return (
    <NavigationContainer>
      <StackNavigator />
    </NavigationContainer>
  );
}
