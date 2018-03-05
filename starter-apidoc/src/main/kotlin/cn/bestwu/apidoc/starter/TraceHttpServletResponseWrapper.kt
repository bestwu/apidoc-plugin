package cn.bestwu.apidoc.starter

import java.io.ByteArrayOutputStream
import java.io.PrintWriter
import java.util.*
import javax.servlet.ServletOutputStream
import javax.servlet.WriteListener
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpServletResponseWrapper

/**
 * @author Peter Wu
 * @since 0.0.1
 */
open class TraceHttpServletResponseWrapper constructor(response: HttpServletResponse) : HttpServletResponseWrapper(response) {

    private val byteArrayOutputStream = ByteArrayOutputStream()

    val responseBody: ByteArray
        get() = byteArrayOutputStream.toByteArray()

    override fun getOutputStream(): ServletOutputStream {
        return TraceServletOutputStream(super.getOutputStream())
    }

    override fun getWriter(): PrintWriter {
        return TracePrintWriter(super.getWriter())
    }

    internal inner class TracePrintWriter(private val delegate: PrintWriter) : PrintWriter(delegate) {
        private val trace: PrintWriter = PrintWriter(byteArrayOutputStream)

        override fun print(b: Boolean) {
            delegate.print(b)
            trace.print(b)
        }

        override fun print(c: Char) {
            delegate.print(c)
            trace.print(c)
        }

        override fun print(i: Int) {
            delegate.print(i)
            trace.print(i)
        }

        override fun print(l: Long) {
            delegate.print(l)
            trace.print(l)
        }

        override fun print(f: Float) {
            delegate.print(f)
            trace.print(f)
        }

        override fun print(d: Double) {
            delegate.print(d)
            trace.print(d)
        }

        override fun print(s: CharArray?) {
            delegate.print(s)
            trace.print(s)
        }

        override fun print(s: String?) {
            delegate.print(s)
            trace.print(s)
        }

        override fun print(obj: Any?) {
            delegate.print(obj)
            trace.print(obj)
        }

        override fun write(c: Int) {
            delegate.write(c)
            trace.write(c)
        }

        override fun write(buf: CharArray?, off: Int, len: Int) {
            delegate.write(buf, off, len)
            trace.write(buf, off, len)
        }

        override fun write(buf: CharArray?) {
            delegate.write(buf)
            trace.write(buf)
        }

        override fun write(s: String?, off: Int, len: Int) {
            delegate.write(s, off, len)
            trace.write(s, off, len)
        }

        override fun write(s: String?) {
            delegate.write(s)
            trace.write(s)
        }

        override fun println() {
            delegate.println()
            trace.println()
        }

        override fun println(x: Boolean) {
            delegate.println(x)
            trace.println(x)
        }

        override fun println(x: Char) {
            delegate.println(x)
            trace.println(x)
        }

        override fun println(x: Int) {
            delegate.println(x)
            trace.println(x)
        }

        override fun println(x: Long) {
            delegate.println(x)
            trace.println(x)
        }

        override fun println(x: Float) {
            delegate.println(x)
            trace.println(x)
        }

        override fun println(x: Double) {
            delegate.println(x)
            trace.println(x)
        }

        override fun println(x: CharArray?) {
            delegate.println(x)
            trace.println(x)
        }

        override fun println(x: String?) {
            delegate.println(x)
            trace.println(x)
        }

        override fun println(x: Any?) {
            delegate.println(x)
            trace.println(x)
        }

        override fun flush() {
            delegate.flush()
            trace.flush()
        }

        override fun checkError(): Boolean {
            trace.checkError()
            return delegate.checkError()
        }

        override fun append(csq: CharSequence?): PrintWriter {
            trace.append(csq)
            return delegate.append(csq)
        }

        override fun append(csq: CharSequence?, start: Int, end: Int): PrintWriter {
            trace.append(csq, start, end)
            return delegate.append(csq, start, end)
        }

        override fun append(c: Char): PrintWriter {
            trace.append(c)
            return delegate.append(c)
        }

        override fun format(format: String?, vararg args: Any?): PrintWriter {
            trace.format(format, *args)
            return delegate.format(format, *args)
        }

        override fun format(l: Locale?, format: String?, vararg args: Any?): PrintWriter {
            trace.format(l, format, *args)
            return delegate.format(l, format, *args)
        }

        override fun printf(format: String?, vararg args: Any?): PrintWriter {
            trace.printf(format, *args)
            return delegate.printf(format, *args)
        }

        override fun printf(l: Locale?, format: String?, vararg args: Any?): PrintWriter {
            trace.printf(l, format, *args)
            return delegate.printf(l, format, *args)
        }

        override fun close() {
            delegate.close()
            trace.close()
        }

        //--------------------------------------------

        override fun equals(other: Any?): Boolean {
            return delegate.equals(other)
        }

        override fun hashCode(): Int {
            return delegate.hashCode()
        }

        override fun toString(): String {
            return delegate.toString()
        }

    }

    internal inner class TraceServletOutputStream(private val delegate: ServletOutputStream) : ServletOutputStream() {

        private val trace = object : ServletOutputStream() {

            override fun isReady(): Boolean {
                return true
            }

            override fun setWriteListener(listener: WriteListener?) {
            }

            override fun write(b: Int) {
                byteArrayOutputStream.write(b)
            }

            override fun write(b: ByteArray?) {
                byteArrayOutputStream.write(b)
            }

            override fun write(b: ByteArray?, off: Int, len: Int) {
                byteArrayOutputStream.write(b, off, len)
            }

            override fun flush() {
                byteArrayOutputStream.flush()
            }

            override fun close() {
                byteArrayOutputStream.close()
            }

        }

        override fun isReady(): Boolean {
            return delegate.isReady
        }

        override fun setWriteListener(listener: WriteListener?) {
            this.delegate.setWriteListener(listener)
        }

        override fun print(s: String?) {
            delegate.print(s)
            trace.print(s)
        }

        override fun print(b: Boolean) {
            delegate.print(b)
            trace.print(b)
        }

        override fun print(c: Char) {
            delegate.print(c)
            trace.print(c)
        }

        override fun print(i: Int) {
            delegate.print(i)
            trace.print(i)
        }

        override fun print(l: Long) {
            delegate.print(l)
            trace.print(l)
        }

        override fun print(f: Float) {
            delegate.print(f)
            trace.print(f)
        }

        override fun print(d: Double) {
            delegate.print(d)
            trace.print(d)
        }

        override fun println() {
            delegate.println()
            trace.println()
        }

        override fun println(s: String?) {
            delegate.println(s)
            trace.println(s)
        }

        override fun println(b: Boolean) {
            delegate.println(b)
            trace.println(b)
        }

        override fun println(c: Char) {
            delegate.println(c)
            trace.println(c)
        }

        override fun println(i: Int) {
            delegate.println(i)
            trace.println(i)
        }

        override fun println(l: Long) {
            delegate.println(l)
            trace.println(l)
        }

        override fun println(f: Float) {
            delegate.println(f)
            trace.println(f)
        }

        override fun println(d: Double) {
            delegate.println(d)
            trace.println(d)
        }

        override fun write(b: Int) {
            this.delegate.write(b)
            trace.write(b)
        }

        override fun write(b: ByteArray?) {
            delegate.write(b)
            trace.write(b)
        }

        override fun write(b: ByteArray?, off: Int, len: Int) {
            delegate.write(b, off, len)
            trace.write(b, off, len)
        }

        override fun flush() {
            delegate.flush()
            trace.flush()
        }

        override fun close() {
            delegate.close()
            trace.close()
        }

        //--------------------------------------------
        override fun equals(other: Any?): Boolean {
            return delegate.equals(other)
        }

        override fun hashCode(): Int {
            return delegate.hashCode()
        }

        override fun toString(): String {
            return delegate.toString()
        }
    }
}
