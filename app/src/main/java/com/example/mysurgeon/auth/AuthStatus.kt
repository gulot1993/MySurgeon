package com.example.mysurgeon.auth

import com.example.mysurgeon.core.status.Status

sealed class AuthStatus: Status() {
    object NavigateToAuth: AuthStatus()

    object NavigateToMain: AuthStatus()
}