interface Command {
    fun execute()
    fun undo()
}

class Light {
    fun on() = println("Light is Turn on ")
    fun off() = println("Light is Turn off ")
}

class Fan {
    var speed: Int? = null

    object SPEED {
        val HIGH: Int = 2
        val LOW: Int = 1
        val OFF: Int = 0
    }

    fun high(): Int? {
        println("Fan Speed goes High")
        speed = SPEED.HIGH
        return speed
    }

    fun low(): Int? {
        println("Fan Speed goes LOW")
        speed = SPEED.LOW
        return speed
    }

    fun off(): Int? {
        println("Fan Speed goes off")
        speed = SPEED.OFF
        return speed
    }
}

class TurnOnLightCommand(private var light: Light) : Command {

    var isTurnOn: Boolean = false
    override fun execute() {

        light.on()
        isTurnOn = true

    }

    override fun undo() {
        if (isTurnOn) light.off()
        else light.on()
        println("undo is called :light is  $isTurnOn")
    }
}

class TurnOffLightCommand(private var light: Light) : Command {

    var isTurnOn: Boolean = false
    override fun execute() {
        light.off()
        isTurnOn = true
    }

    override fun undo() {
        if (isTurnOn) light.off()
        else light.on()

        println("undo is called :light is  $isTurnOn")
    }
}

class FanOffCommand(private val fan: Fan) : Command {
    var prevFanSpeed: Int? = null
    override fun execute() {

        prevFanSpeed = fan.speed
        fan.off()
    }

    override fun undo() {
        prevFanSpeed?.let {

            when (prevFanSpeed) {
                Fan.SPEED.HIGH -> fan.high()
                Fan.SPEED.LOW -> fan.low()
                Fan.SPEED.OFF -> fan.off()
                else -> null
            }
        }

    }
}

class RemoteControl {

    private val commandList = HashMap<Int, Command>()
    private var undoCommand: Command? = null

    fun setCommand(slot: Int, turnOnCommand: Command) {
        commandList[slot] = turnOnCommand
    }

    fun onButtonWasPushed(slot: Int) {

        commandList[slot]?.execute()
        undoCommand = commandList[slot]
    }

    fun undo() = undoCommand?.undo()
}

fun main(args: Array<String>) {


    val remoteControl = RemoteControl()
    val light = Light()
    remoteControl.setCommand(0, TurnOnLightCommand(light))
    remoteControl.setCommand(1, TurnOffLightCommand(light))

    val fan = Fan()

    remoteControl.setCommand(2, FanOffCommand(fan))
    remoteControl.onButtonWasPushed(0)
    remoteControl.onButtonWasPushed(1)
    remoteControl.undo()
    remoteControl.onButtonWasPushed(2)
    remoteControl.undo()

}