import React from 'react';
import { Alert } from 'react-native';
import { useDispatch } from 'react-redux';
import PropTypes from 'prop-types';

import { Container, TextHome, ButtonLogout } from './styles';

import { signOut } from '~/store/modules/auth/actions';

export default function Home({ navigation }) {
  const dispatch = useDispatch();

  function handleLogout() {
    Alert.alert('Atenção !', 'Você deseja sair do App ?', [
      {
        text: 'Não',
        style: 'cancel',
      },
      { text: 'Sim', onPress: () => dispatch(signOut()) },
    ]);
  }

  return (
    <Container>
      <TextHome>Home</TextHome>
      <ButtonLogout onPress={handleLogout}>Sair</ButtonLogout>
    </Container>
  );
}

Home.propTypes = {
  navigation: PropTypes.oneOfType([PropTypes.object]).isRequired,
};
