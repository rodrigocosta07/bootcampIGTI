import React from 'react';
import {StyleSheet,View, Text} from 'react-native'
const HomeScreen = () => {
  return (
    <View style={styles.viewStyle}>
      <Text>Ola</Text>
    </View>
  )
}

export default HomeScreen;

const styles = StyleSheet.create({
  viewStyle: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center'
  }
});