import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import HomeScreen from './src/screens/Home';
import { createStackNavigator } from '@react-navigation/stack';
const Stack = createStackNavigator();
function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Series Inc" component={HomeScreen} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

export default App;