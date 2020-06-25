import { Alert } from 'react-native';
import { takeLatest, call, put, all } from 'redux-saga/effects';

import api from '~/services/api';

import { signInSuccess, signFailure } from './actions';

export function* signIn({ payload }) {
  try {
    const { username, password } = payload;
    // const response = yield call(api.post, 'doctor/auth', {
    //   username,
    //   password,
    // });

    // const {
    //   data: { tokenAccess },
    // } = response.data;

    const tokenAccess = 'TOKEN_ACCESS';

    api.defaults.headers.Authorization = `Bearer ${tokenAccess}`;

    yield put(signInSuccess(tokenAccess));
  } catch (error) {
    Alert.alert('Falha na autenticação', 'usuário ou senha inválido');

    yield put(signFailure());
  }
}

export function setToken({ payload }) {
  if (!payload) {
    return;
  }

  const { token } = payload.auth;
  if (token) {
    api.defaults.headers.Authorization = `Bearer ${token}`;
  }
}

export default all([
  takeLatest('persist/REHYDRATE', setToken),
  takeLatest('@auth/SIGN_IN_REQUEST', signIn),
]);
