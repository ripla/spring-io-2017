importScripts('bower_components/sw-toolbox/sw-toolbox.js');

toolbox.router.get('index.html', toolbox.cacheFirst);
toolbox.router.get('example2.html', toolbox.cacheFirst);
toolbox.router.get('bower_components*', toolbox.cacheFirst);
toolbox.router.get('manifest.json', toolbox.cacheFirst);
toolbox.router.get('service-worker.js', toolbox.cacheFirst);
toolbox.router.get('weather/current/*', toolbox.cacheFirst);