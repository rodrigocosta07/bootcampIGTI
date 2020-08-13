import React from 'react';
import { styleSheet } from 'react-native';
import { TextInput } from 'react-native-gesture-handler';

const Input = () => {
  return (
    <>
      <Text>props.label</Text>
      <TextInput value={props.value} style={styleSheet.textInputStyle} onChangeText={props.onChange} />
    </>
  );
}

export default Input;
const styles = StyleSheet.create({
  textInputStyle: {
    backgroundColor: '#d1cdcd'
  }
})