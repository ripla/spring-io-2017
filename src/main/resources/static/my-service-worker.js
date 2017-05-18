importScripts('bower_components/sw-toolbox/sw-toolbox.js');

toolbox.router.get('index2.html', toolbox.cacheFirst);
toolbox.router.get('current-weather.html', toolbox.cacheFirst);
toolbox.router.get('bower_components*', toolbox.cacheFirst);
toolbox.router.get('manifest.json', toolbox.cacheFirst);
toolbox.router.get('service-worker.js', toolbox.cacheFirst);
toolbox.router.get('weather/current/*', toolbox.cacheFirst);