//import { StatusBar } from "expo-status-bar";
import React from "react";
import {
  StyleSheet,
  Text,
  View,
  TouchableWithoutFeedback,
  Alert,
  TouchableHighlight,
  Image,
  SafeAreaView,
  Button,
  Platform,
  StatusBar,
  Dimensions,
} from "react-native";

import {
  useDimensions,
  useDeviceOrientation,
} from "@react-native-community/hooks";
import WelcomeScreen from "./app/screens/WelcomeScreen";

// export default function App() {
//   const handlePress = () => console.log("Text Pressed");
//   return (
//     // Safe Area view only works on IOS
//     <SafeAreaView style={styles.container}>
//       <Text>Open up App.js to start working on your app!</Text>
//       <TouchableHighlight onPress={() => console.log("Touchable touched")}>
//         <Image
//           blurRadius={1}
//           fadeDuration={1000}
//           source={{
//             width: 200,
//             height: 300,
//             uri: "https://picsum.photos/seed/picsum/200/300",
//           }}
//         />
//       </TouchableHighlight>
//       <Text numberOfLines={1} onPress={handlePress}>
//         Hello fam just but its really really long and wrapped Hello fam just but
//         its really really long andwrapped Hello fam just but its really really
//         long and wrapped Hello fam just but its really really long and wrapped
//       </Text>
//       <Image source={require("./assets/favicon.png")} />
//       <Button
//         title="Click me / Alert"
//         onPress={() =>
//           Alert.alert("My title", "my message", [
//             { text: "yes", onPress: () => console.log("yes pressed") },
//             { text: "no", onPress: () => console.log("no pressed") },
//           ])
//         }
//       />
//     </SafeAreaView>
//   );
// }
// const containerStyle = { backgroundColor: "black" };

// export default function App() {
//   // Equal on Ios, smaller windows on Android
//   // console.log(Dimensions.get("screen"));
//   // console.log(useDimensions());
//   // console.log(useDeviceOrientation());
//   // Have to specify value sinve orientation calls for landscape and portait
//   const { landscape } = useDeviceOrientation();

//   return (
//     <SafeAreaView style={styles.container}>
//       <View
//         style={{
//           backgroundColor: "dodgerblue",
//           width: "100%",
//           height: landscape ? "100%" : "30%",
//         }}
//       ></View>
//     </SafeAreaView>
//   );
// }

export default function App() {
  return <WelcomeScreen></WelcomeScreen>;
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "white",
    // justifyContent: "center",
    // alignItems: "center",
    paddingTop: Platform.OS === "android" ? StatusBar.currentHeight : 0,
  },
});
