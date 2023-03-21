package com.example.dam_m08_act4_anacarton;

import android.view.View;

public class Juego extends View {

    // Extensión de una View. Totalmente necesario para dibujar

        public int ancho,alto;
        public float escala;
        public int posX,posY,radio,posMonedaX,posMonedaY;
        private GestureDetector gestos;
        private RectF rectCesta;
        private RectF rectMoneda;
        private Random random = new Random();
        public Juego(Context context) {
            super(context);
        }
        public Juego(Context context, AttributeSet attrs) {
            super(context, attrs);
        }
        //Sección que capta los eventos del usuario
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            // you may need the x/y location
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    break;
                case MotionEvent.ACTION_UP:
                    break;
                case MotionEvent.ACTION_MOVE:
                    posX=(int)event.getX();
                    radio=50;
                    this.invalidate();
            }
            return true;
        }
        public Juego(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
        }
        @SuppressLint("DrawAllocation")
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            //Definimos los objetos a pintar
            Paint fondo = new Paint();
            Paint cesta = new Paint();
            Paint moneda = new Paint();
            //Definimos los colores de los objetos a pintar
            fondo.setColor(Color.BLACK);
            fondo.setStyle(Paint.Style.FILL_AND_STROKE);
            cesta.setColor(Color.YELLOW);
            cesta.setStyle(Paint.Style.FILL_AND_STROKE);
            moneda.setColor(Color.RED);
            moneda.setStyle(Paint.Style.FILL_AND_STROKE);
            //Pinto rectángulo con un ancho y alto de 1000 o de menos si la pantalla es menor.
            canvas.drawRect(new Rect(0,0,(ancho),(alto)),fondo);
            // Pinto la pelota. La Y la implementa el timer y la X la pongo aleatoreamente en cuanto llega al final
            rectCesta= new RectF((posX-radio),(posY-radio),(posX+radio),(posY+radio));
            canvas.drawOval(rectCesta,cesta);
            //Pintamos moneda
            if (posMonedaY>alto) {
                posMonedaY=50;
                posMonedaX= random.nextInt(ancho);
            }
            rectMoneda = new RectF((posMonedaX-radio),(posMonedaY-radio),(posMonedaX+radio),(posMonedaY+radio));
            canvas.drawOval(rectMoneda,moneda);
        }
    }


