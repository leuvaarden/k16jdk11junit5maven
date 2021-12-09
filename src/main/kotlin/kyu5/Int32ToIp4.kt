package kyu5

object Int32ToIp4 {
    fun longToIP(ip: UInt): String =
        "${ip.shr(24)}.${ip.shr(16).and(255u)}.${ip.shr(8).and(255u)}.${ip.and(255u)}"
}
