import 'moment/locale/pt-br';
import 'react-native-gesture-handler';
// import { gestureHandlerRootHOC } from 'react-native-gesture-handler';
import { AppRegistry } from 'react-native';
import App from './src';
import { name as appName } from './app.json';

AppRegistry.registerComponent(appName, () => App);
