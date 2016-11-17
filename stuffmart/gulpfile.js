
var fs = require('fs');

var gulp = require('gulp');
var sass = require('gulp-sass');
var sourcemaps = require('gulp-sourcemaps');

var sourceWebappDir = 'src/main/webapp';
var buildWebappDir = 'build/inplaceWebapp';

var stylesSrcDir = sourceWebappDir + '/style';
var stylesDestDir =  buildWebappDir + '/style';

gulp.task('sass', function() {

    return gulp.src(stylesSrcDir + '/*.scss')
        .pipe(sourcemaps.init())
        .pipe(sass({ outputStyle: 'compressed' }).on('error', sass.logError))
        .pipe(sourcemaps.write('./maps'))
        .pipe(gulp.dest(stylesDestDir) );

});

gulp.task('watch', function () {
    gulp.watch(sourceWebappDir + '/**', ['sass']);
});


/* all */

gulp.task('default', [ 'sass' ], function() { });
