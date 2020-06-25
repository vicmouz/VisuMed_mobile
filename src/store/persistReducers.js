import AsyncStorage from '@react-native-community/async-storage';
import { persistReducer } from 'redux-persist';

export default reducers => {
  const persistedReducer = persistReducer(
    {
      key: 'simcoMedico',
      storage: AsyncStorage,
      whitelist: ['auth', 'doctor'],
    },
    reducers
  );

  return persistedReducer;
};
