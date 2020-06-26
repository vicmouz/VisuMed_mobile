import React, { useRef, useState } from 'react';
import { TouchableWithoutFeedback, Keyboard } from 'react-native';
import { useDispatch, useSelector } from 'react-redux';

import { signInRequest } from '~/store/modules/auth/actions';

import {
  Container,
  Form,
  FormInput,
  SubmitButton,
  FacebookButton,
  GoogleButton,
  RecoverButton,
} from './styles';

export default function Login() {
  const dispatch = useDispatch();
  const passwordRef = useRef();

  const [userName, setUserName] = useState('');
  const [password, setPassword] = useState('');

  const loading = useSelector(state => state.auth.loading);

  function handleSubmit() {
    dispatch(signInRequest(userName, password));
  }

  return (
    <TouchableWithoutFeedback onPress={Keyboard.dismiss}>
      <Container>
        <FacebookButton>Logar-se via Facebook</FacebookButton>
        <GoogleButton>Logar-se via Google</GoogleButton>
        <Form>
          <FormInput
            icon="mail-outline"
            keyboardType="default"
            autoCorrect={false}
            autoCapitalize="none"
            placeholder="Usuário"
            returnKeyType="next"
            onSubmitEditing={() => passwordRef.current.focus()}
            value={userName}
            onChangeText={setUserName}
          />
          <FormInput
            icon="lock-outline"
            secureTextEntry
            placeholder="Senha"
            ref={passwordRef}
            returnKeyType="send"
            onSubmitEditing={handleSubmit}
            value={password}
            onChangeText={setPassword}
          />

          <SubmitButton loading={loading} onPress={handleSubmit}>
            Entrar
          </SubmitButton>
          <RecoverButton>Esqueceu sua senha?</RecoverButton>
        </Form>
      </Container>
    </TouchableWithoutFeedback>
  );
}
