import ReactDOM from 'react-dom';
import createRoutes from './routes';

const routes = createRoutes();

ReactDOM.render(
  routes,
  document.getElementById('root')
);
