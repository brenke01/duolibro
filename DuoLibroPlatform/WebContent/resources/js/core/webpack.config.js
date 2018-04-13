const path = require('path');

var config = {
   entry: './main.js',
   output: {
	    path: __dirname +  '/dist',
	    publicPath: '/DuoLibroPlatform/resources/js/core/dist',
       filename: 'bundle.js'
   },
   devServer: {
      inline: true,
      port: 4200,
      hot: true,
      proxy: {
          '/': {
              target: 'http://localhost:8080', 
              secure: false
          }
      }
   },
   module: {
      loaders: [
         {
            test: /\.jsx?$/,
            exclude: /node_modules/,
            loader: 'babel-loader',
            query: {
               presets: ['es2015', 'react']
            }
         }
      ]
   }
}
module.exports = config;