const path = require('path');
const CompressionPlugin = require('compression-webpack-plugin');

const resolve = dir => path.join(__dirname, dir);

const BASE_URL = process.env.NODE_ENV === 'production'
  ? '/'
  : '/';

module.exports = {
  publicPath: BASE_URL,
  runtimeCompiler: true,
  lintOnSave: true,
  outputDir: 'dist',
  assetsDir: undefined,
  productionSourceMap: false,
  parallel: true,

  chainWebpack: (config) => {
    config.resolve.alias
      .set('@', resolve('src'))
      .set('_c', resolve('src/components'));
  },
  configureWebpack: () => {
    if (process.env.NODE_ENV === 'production') {
      return {
        plugins: [new CompressionPlugin({
          test: /\.js$|\.html$|\.css/,
          threshold: 10240,
          deleteOriginalAssets: false,
        })],
        devtool: false,
        performance: {
          maxEntrypointSize: 1024000,
          maxAssetSize: 2048000,
        },
      };
    }
    return {};
  },
  css: {
    loaderOptions: {
      sass: {
        javascriptEnabled: true,
      },
    },
  },
  devServer: {
    open: process.platform === 'darwin',
    host: '0.0.0.0',
    port: 8080,
    https: false,
    hotOnly: false,
    disableHostCheck: true,
    proxy: {
      '/api': {
        target: 'http://127.0.0.1:9090',
        changeOrigin: true,
        // ws: true,
        pathRewrite: {
          '^/api': '',
        },
        logLevel: 'debug',
      },
    },
    before: () => {},
  },
};
