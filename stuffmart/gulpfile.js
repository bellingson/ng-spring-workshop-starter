
var gulp = require('gulp');
var sass = require('gulp-sass');
var sourcemaps = require('gulp-sourcemaps');

var _ = require('lodash');

var sourceWebappDir = 'src/main/webapp';
var buildWebappDir = 'build/inplaceWebapp';

var stylesSrcDir = 'src/main/webapp/style';
var stylesDestDir =  buildWebappDir + '/style';

gulp.task('sass', function() {

    return gulp.src(stylesSrcDir + '/*.scss')
        .pipe(sourcemaps.init())
        .pipe(sass({ outputStyle: 'compressed' }).on('error', sass.logError))
        .pipe(sourcemaps.write('./maps'))
        .pipe(gulp.dest(stylesDestDir) );

});

gulp.task('copyapp', ['sass'], function() {

    return gulp.src(sourceWebappDir + '/**/*')
        .pipe(gulp.dest(buildWebappDir));

});

gulp.task('watch', function () {
    gulp.watch(sourceWebappDir + '/**', ['copyapp']);
});

/* ng2 section */

var execV = require('exec-with-verify');

var ng2Apps = [ { src: 'src/main/js/product-mgr', dest: '/admin/product/app' } ];

var ngBuildPath = '../../../../build/inplaceWebapp';

gulp.task('ng:install', function() {

    var configs = ng2Apps.map(function(app) {
        return { cmd: 'npm install', cwd: app };
    });

    return execV.execWithVerify(configs);
});

gulp.task('ng:build', function() {
    return buildNgApps(false);
});

gulp.task('ng:dist', [ 'ng:install'], function() {
    return buildNgApps(true);
});

function buildNgApps(isProd) {

    // ng build --prod --output-path=../../../../build/inplaceWebapp/admin/product/app

    var execConfig = ng2Apps.map(function(app) {

        var outputPath = ' --output-path=' +  ngBuildPath + app.dest;

        var cmd = 'ng build ' + (isProd ? ' --prod ' : ' ') + outputPath;
        return { cmd: cmd, cwd: app.src };
    });

    return execV.execWithVerify(execConfig);
}

/* all */

// gulp.task('default', [ 'copyapp', 'ng:dist' ], function() { });
// gulp.task('default', [ 'copyapp', 'ng:build' ], function() { });
gulp.task('default', [ 'copyapp' ], function() { });
