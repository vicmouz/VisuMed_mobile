import Reactotron, { overlay } from 'reactotron-react-native';
import { reactotronRedux } from 'reactotron-redux';
import reactotronSaga from 'reactotron-redux-saga';

if (__DEV__) {
  const tron = Reactotron.configure({ host: '192.168.15.19' })
    .useReactNative()
    .use(reactotronRedux())
    .use(reactotronSaga())
    .use(overlay())
    .connect();

  tron.clear();

  console.tron = tron;
}
